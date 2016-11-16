package com.tw.study.springboot.controller;

import com.tw.study.springboot.config.ExcelView;
import com.tw.study.springboot.entity.Excel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

/**
 * Created by hwwei on 2016/11/16.
 */
@Controller
@RequestMapping("excel")
public class ExcelDownloadController {

    @RequestMapping
    public ModelAndView down(@RequestBody List<Excel> content) {
        return ExcelView.newModelAndView(content == null ? Collections.emptyList() : content);
    }
}
