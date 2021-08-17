package mx.santander.fiduciarioplus.dto.getprofile;




import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataDto implements Serializable
{

	 private ProfileDto profile;
    private final static long serialVersionUID = 4368260677291882679L;

}
