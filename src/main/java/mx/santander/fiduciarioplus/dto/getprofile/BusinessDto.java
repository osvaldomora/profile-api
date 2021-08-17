package mx.santander.fiduciarioplus.dto.getprofile;




import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.santander.fiduciarioplus.dto.enums.TypeBusiness;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessDto implements Serializable
{
	@JsonProperty("id")
    private String bussiness;
	private TypeBusiness typeBusiness;
	
//	private String status;
    @JsonProperty("subBusiness")
    private List<SubBusinessDto> subnegocios = null;
    
    private final static long serialVersionUID = 8502473078842270739L;

}
