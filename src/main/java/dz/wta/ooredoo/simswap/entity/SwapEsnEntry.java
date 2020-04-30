package dz.wta.ooredoo.simswap.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SWAP_ESN")
public class SwapEsnEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	@JsonIgnore
	private Long id;

	@NotEmpty(message = "please provide an msisdn")
	@NotNull
	@Pattern(regexp = "^5[0-9]{8}$", message = "invalid msisdn storm")
	@Column(name = "MSISDNSTORM")
	private String msisdn;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "MODIFICATION_DTE")
	private Date modifDate;

	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	@Column(name = "STATUS")
	@Min(0)
	@Max(1)
	private int status;

	public SwapEsnEntry() {

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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifDate() {
		return modifDate;
	}

	public void setModifDate(Date modifDate) {
		this.modifDate = modifDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
