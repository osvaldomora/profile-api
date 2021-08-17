package mx.santander.fiduciarioplus.model.profile;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ACCESS")
public class Access implements Serializable {
	

	private static final long serialVersionUID = 5286306995658242296L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	

	@Column(name = "ID_ACCESS")
	private String idAccess;
	
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="SUB_BUSINESS")
//	private SubBusiness subBusiness;
	

	


 

}
