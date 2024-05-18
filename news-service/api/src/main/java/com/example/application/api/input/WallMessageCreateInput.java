package com.example.application.api.input;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class WallMessageCreateInput {

    private String content;

    private List<String> fileIds;
}

