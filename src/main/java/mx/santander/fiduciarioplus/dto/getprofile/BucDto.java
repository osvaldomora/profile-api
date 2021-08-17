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
public class BucDto implements Serializable
{

    private String id;
    private String type;
    private final static long serialVersionUID = 9065254856609803058L;

}
