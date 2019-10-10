package com.ing.mortgage.service;


import java.util.List;

import com.ing.mortgage.dto.RequestLoanDto;
import com.ing.mortgage.dto.RequestLoginDto;



public interface LoginService {
public List<RequestLoanDto> loanDetails(RequestLoginDto requestLoginDto);
}
