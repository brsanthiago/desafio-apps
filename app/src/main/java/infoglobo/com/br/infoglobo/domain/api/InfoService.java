package infoglobo.com.br.infoglobo.domain.api;

import java.util.ArrayList;
import infoglobo.com.br.infoglobo.domain.model.InfoContent;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Bruno Santiago on 11/09/17.
 */

public interface InfoService {

    @GET("capa.json")
    Call<ArrayList<InfoContent>> findNotices();
}
