package com.codigo.infrastructure.client.retrofit;

import com.codigo.infrastructure.client.dto.SunatResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface SunatClientRetrofit {

    @GET("full")
    Call<SunatResponse> getEmpresa(
            @Query("numero") String ruc,
            @Header("Authorization") String token
    );
}
