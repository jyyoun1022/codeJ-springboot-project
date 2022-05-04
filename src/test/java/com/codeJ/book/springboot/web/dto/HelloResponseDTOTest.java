package com.codeJ.book.springboot.web.dto;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class HelloResponseDTOTest {


    @Test
    public void 롬복_기능_테스트(){
        //given
        String name ="test";
        int amount = 1000;
        //when
        HelloResponseDTO dto = new HelloResponseDTO(name,amount);
        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
