package com.codigo.infrastructure.client.retrofit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.apis.net.pe/v2/sunat/ruc/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Bean
    public SunatClientRetrofit sunatClientRetrofit(Retrofit retrofit) {
        return retrofit.create(SunatClientRetrofit.class);
    }
}
