package com.trendyol.mockapi.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MathService {

    public float sum(List<Integer> params) {
        float result = 0;
        for (int i = 1; i <= params.get(0); i++) {
            result += i;
        }

        return result;
    }

    public float add(List<Integer> params) {
        float result = 0;
        for (Integer param : params) {
            result += param;
        }

        return result;
    }

    public float subtraction(List<Integer> params) {
        float result = params.get(0);
        params.remove(0);
        for (Integer param : params) {
            result -= param;
        }

        return result;
    }

    public float division(List<Integer> params) {
        float result = params.get(0);
        params.remove(0);
        for (Integer param : params) {
            result /= param;
        }

        return result;
    }

    public float multiplication(List<Integer> params) {
        float result = 1;
        for (Integer param : params) {
            result *= param;
        }

        return result;
    }
}
