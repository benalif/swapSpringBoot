package dz.wta.ooredoo.simswap.controller;

import static dz.wta.ooredoo.simswap.model.GenericResponse.ERROR_MESSAGE;
import static dz.wta.ooredoo.simswap.model.GenericResponse.ESN_NOT_ILLIGIBLE_MESSAGE;
import static dz.wta.ooredoo.simswap.model.GenericResponse.NOT_EXIST_REASON;
import static dz.wta.ooredoo.simswap.model.GenericResponse.SIM_ALREADY_DEACTIVATED_MESSAGE;
import static dz.wta.ooredoo.simswap.model.GenericResponse.SIM_ALREADY_EXISTS_MESSAGE;
import static dz.wta.ooredoo.simswap.model.GenericResponse.SIM_DEACTIVATED_MESSAGE;
import static dz.wta.ooredoo.simswap.model.GenericResponse.SIM_NOT_EXISTS_MESSAGE;
import static dz.wta.ooredoo.simswap.model.GenericResponse.SUCCESS_MESSAGE;

import java.util.Date;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import dz.wta.ooredoo.simswap.entity.SwapEntry;
import dz.wta.ooredoo.simswap.entity.SwapEsnEntry;
import dz.wta.ooredoo.simswap.helper.Helper;
import dz.wta.ooredoo.simswap.model.GenericResponse;
import dz.wta.ooredoo.simswap.model.GetSimswapsResponse;
import dz.wta.ooredoo.simswap.model.ReasonsResponse;
import dz.wta.ooredoo.simswap.model.SwapEntryResponse;
import dz.wta.ooredoo.simswap.repository.ReasonRepository;
import dz.wta.ooredoo.simswap.repository.Repository;
import dz.wta.ooredoo.simswap.repository.SwapEsnRepository;

@RestController
@RequestMapping("/api/")
@Validated
public class HomeController {

	@Autowired
	SwapEsnRepository swapEsnRepository;

	@Autowired
	Repository repository;

	@Autowired
	ReasonRepository reasonRepository;

	@PostMapping("/insert")
	public ResponseEntity<?> postSim(@RequestBody @Valid SwapEntry swapEntry) {

		Objects.requireNonNull(swapEntry, "swap Enty should not be empty");
		if (Objects.isNull(swapEsnRepository.findBymsisdn(swapEntry.getMsisdnStorm()))) {
			return new ResponseEntity<GenericResponse>(new GenericResponse(1, ESN_NOT_ILLIGIBLE_MESSAGE),
					HttpStatus.OK);
		}

		if (Objects.isNull(reasonRepository.findByreason(swapEntry.getReason()))) {
			return new ResponseEntity<GenericResponse>(new GenericResponse(1, NOT_EXIST_REASON), HttpStatus.OK);
		}

		swapEntry.setRandomCode(Helper.getRandomCode());

		// TODO SEND SMS AND RETRIEVE RESPONSE ID

		if (Objects.isNull(repository.save(swapEntry))) {
			return new ResponseEntity<GenericResponse>(new GenericResponse(1, ERROR_MESSAGE), HttpStatus.OK);
		}

		return new ResponseEntity<SwapEntryResponse>(new SwapEntryResponse(0, SUCCESS_MESSAGE, swapEntry),
				HttpStatus.OK);

	}

	@PostMapping("/add-simswap")
	public ResponseEntity<?> postSimSwap(@RequestBody @Valid SwapEsnEntry sim, @RequestAttribute String username) {
		SwapEsnEntry simswap = swapEsnRepository.findBymsisdn(sim.getMsisdn());

		if (Objects.isNull(simswap)) {
			sim.setCreationDate(new Date());
			sim.setModifiedBy(username);
			swapEsnRepository.save(sim);
			return new ResponseEntity<GenericResponse>(new GenericResponse(1, SUCCESS_MESSAGE), HttpStatus.OK);
		} else if (simswap.getStatus() == 0) {
			simswap.setModifiedBy(username);
			simswap.setStatus(1);
			simswap.setModifDate(new Date());
			swapEsnRepository.save(simswap);
			return new ResponseEntity<GenericResponse>(new GenericResponse(1, SUCCESS_MESSAGE), HttpStatus.OK);
		} else {
			return new ResponseEntity<GenericResponse>(new GenericResponse(1, SIM_ALREADY_EXISTS_MESSAGE),
					HttpStatus.OK);
		}
	}

	@PostMapping("/delete-simswap/{msisdn}")
	public ResponseEntity<?> deleteSimSwap(
			@Pattern(regexp = "^5[0-9] {8}$", message = "invalid msisdn") @NotNull @PathVariable("msisdn") String msisdn,
			@RequestAttribute String username) {

		SwapEsnEntry simswap = swapEsnRepository.findBymsisdn(msisdn);

		if (Objects.isNull(simswap)) {
			return new ResponseEntity<GenericResponse>(new GenericResponse(1, SIM_NOT_EXISTS_MESSAGE), HttpStatus.OK);
		} else if (simswap.getStatus() == 0) {

			return new ResponseEntity<GenericResponse>(new GenericResponse(1, SIM_ALREADY_DEACTIVATED_MESSAGE),
					HttpStatus.OK);
		} else {
			simswap.setStatus(0);
			simswap.setModifDate(new Date());
			simswap.setModifiedBy(username);
			swapEsnRepository.save(simswap);
			return new ResponseEntity<GenericResponse>(new GenericResponse(1, SIM_DEACTIVATED_MESSAGE), HttpStatus.OK);
		}
	}

	@GetMapping("/reasons")
	public ResponseEntity<?> getReason() {

		return new ResponseEntity<ReasonsResponse>(new ReasonsResponse(0, SUCCESS_MESSAGE, reasonRepository.findAll()),
				HttpStatus.OK);
	}

	@GetMapping("/simswaps")
	public ResponseEntity<?> getSimSwaps() {
		return new ResponseEntity<GetSimswapsResponse>(
				new GetSimswapsResponse(0, SUCCESS_MESSAGE, swapEsnRepository.findAll()), HttpStatus.OK);

	}
}
