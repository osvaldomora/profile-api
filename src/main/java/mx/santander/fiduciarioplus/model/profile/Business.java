package mx.santander.fiduciarioplus.model.profile;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "BUSINESS")
public class Business implements Serializable {
	

	private static final long serialVersionUID = 5286306995658242296L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	
	@Column(name = "NO_CONTRATO", nullable = false)
	private String bussiness;
	
	@Column(name = "MAESTRO_NO", nullable = false)
	private String typeBusiness;
	
//	@Column(name = "CONTRATO", nullable = false)
//	private String status;
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="PROFILE_ID", nullable = false,referencedColumnName="ID")
//	private Profile profile;
	

	//PARA OBTENER LA LISTA DE subNEGOCIOS PERO NO FUNCIONA EN H2
//	@OneToMany(mappedBy = "business", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonInclude()
	@Transient
	private List<SubBusiness> subnegocios;
	

	


 

}
