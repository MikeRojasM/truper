package com.truper.service.security;

import com.truper.dao.request.SignUpRequest;
import com.truper.dao.request.SigninRequest;
import com.truper.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
