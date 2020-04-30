package dz.wta.ooredoo.simswap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dz.wta.ooredoo.simswap.validator.Reason;

@Entity
@Table(name = "SWAPSIM")
public class SwapEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SWAPSIM_SEQ")
	@SequenceGenerator(name = "SWAPSIM_SEQ", sequenceName = "SWAPSIM_SEQ")
	@JsonIgnore
	private Long id;

	@NotEmpty(message = "please provide an msisdn")
	@NotNull
	@Pattern(regexp = "^5[0-9]{8}$", message = "invalid msisdn storm")
	@Column(name = "MSISDN")
	private String msisdn;

	@NotEmpty(message = "please provide an msisdn storm")
	@NotNull
	@Pattern(regexp = "^5[0-9]{8}$", message = "invalid msisdn storm")
	@Column(name = "MSISDN_STORM")
	private String msisdnStorm;

	@JsonIgnore
	@Column(name = "RANDOM_CODE")
	private String randomCode;

	@Reason
	@NotEmpty(message = "please provide a reason")
	@NotNull
	@Column(name = "RAISON")
	private String reason;

	@JsonIgnore
	@Column(name = "CREATEDBY")
	private String createdBy;

	@JsonIgnore
	@Column(name = "SMS_ID")
	private String responseId;

	public SwapEntry() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getMsisdnStorm() {
		return msisdnStorm;
	}

	public void setMsisdnStorm(String msisdnStorm) {
		this.msisdnStorm = msisdnStorm;
	}

	public String getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public SwapEntry(String msisdn, String msisdnStorm, String randomCode, String reason, String createdBy) {
		super();
		this.msisdn = msisdn;
		this.msisdnStorm = msisdnStorm;
		this.randomCode = randomCode;
		this.reason = reason;
		this.createdBy = createdBy;
	}

}
