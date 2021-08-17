package mx.santander.fiduciarioplus.model.profile;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "PROFILE")
public class Profile implements Serializable {

	private static final long serialVersionUID = 5286306995658242296L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

//	@Size(min = 12, max = 12)
	@Column(name = "BUC")
	private String buc;

	@Column(name = "TIPO")
	private String type ;
	
	@Column(name = "ESTATUS")
	private String status;

	//PARA OBTENER LA LISTA DE NEGOCIOS PERO NO FUNCIONA EN H2
//	@OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JsonInclude()
	@Transient
	private List<Business> negocios;

}
