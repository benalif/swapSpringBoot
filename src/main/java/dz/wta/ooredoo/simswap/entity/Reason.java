package dz.wta.ooredoo.simswap.entity;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REASONS")
public class Reason {

	public static Comparator<Reason> SORT_BY_ID = new Comparator<Reason>() {

		@Override
		public int compare(Reason o1, Reason o2) {
			// TODO Auto-generated method stub
			return Long.compare(o1.getId(), o2.getId());
		}
	};

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "reason")
	private String reason;

	public Reason() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
