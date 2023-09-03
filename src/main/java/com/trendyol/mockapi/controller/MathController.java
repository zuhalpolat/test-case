package com.trendyol.mockapi.controller;


import com.trendyol.mockapi.model.response.ApiResponse;
import com.trendyol.mockapi.model.response.UserInfo;
import com.trendyol.mockapi.service.AuthService;
import com.trendyol.mockapi.service.MathService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class MathController {
    private final MathService mathService;
    private final AuthService authService;

    @GetMapping(value = "sum")
    public ApiResponse sum(@RequestHeader(value="username") String username,
                           @RequestHeader(value="password") String password,
                           @RequestParam("params") @Size(min = 1, max = 1) List<@Valid Integer> params) throws AuthenticationException {
        authService.isAuthenticated(username, password);
        return ApiResponse.builder()
                .result(mathService.sum(params))
                .userInfo(UserInfo.builder().username(username).password(password).build())
                .build();
    }

    @PostMapping(value = "add")
    public ApiResponse add(@RequestHeader(value="username") String username,
                           @RequestHeader(value="password") String password,
                           @RequestParam("params") @Size(min = 2, max = 5) List<@Valid Integer> params) throws AuthenticationException {
        authService.isAuthenticated(username, password);

        return ApiResponse.builder()
                .result(mathService.add(params))
                .userInfo(UserInfo.builder().username(username).password(password).build())
                .build();
    }

    @PostMapping(value = "subtraction")
    public ApiResponse subtraction(@RequestHeader(value="username") String username,
                                   @RequestHeader(value="password") String password,
                                   @RequestParam("params") @Size(min = 2, max = 5) List<@Valid Integer> params) throws AuthenticationException {
        authService.isAuthenticated(username, password);

        return ApiResponse.builder()
                .result(mathService.subtraction(params))
                .userInfo(UserInfo.builder().username(username).password(password).build())
                .build();
    }

    @PostMapping(value = "division")
    public ApiResponse division(@RequestHeader(value="username") String username,
                                @RequestHeader(value="password") String password,
                                @RequestParam("params") @Size(min = 2, max = 5) List<@Valid Integer> params) throws AuthenticationException {
        authService.isAuthenticated(username, password);
        return ApiResponse.builder()
                .result(mathService.division(params))
                .userInfo(UserInfo.builder().username(username).password(password).build())
                .build();
    }

    @PostMapping(value = "multiplication")
    public ApiResponse multiplication(@RequestHeader(value="username") String username,
                                      @RequestHeader(value="password") String password,
                                      @RequestParam("params") @Size(min = 2, max = 5) List<@Valid Integer> params) throws AuthenticationException {
        authService.isAuthenticated(username, password);
        return ApiResponse.builder()
                .result(mathService.multiplication(params))
                .userInfo(UserInfo.builder().username(username).password(password).build())
                .build();
    }
}
