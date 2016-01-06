package org.masich.samples.springboot.resthandlerforplaintext.rest;


import org.masich.samples.springboot.resthandlerforplaintext.rest.model.RequestPojoSample;
import org.masich.samples.springboot.resthandlerforplaintext.rest.model.ResponsePojoSample;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/samples")
public class SampleRestController {

    @RequestMapping(path = "/raw", method = RequestMethod.POST)
    public String rawRequest(HttpEntity<String> request) {

        return request.getBody();
    }

    @RequestMapping(path = "/pojo", method = RequestMethod.POST)
    public ResponsePojoSample rawRequest(@RequestBody RequestPojoSample request) {

        ResponsePojoSample responsePojoSample = new ResponsePojoSample();
        responsePojoSample.setResponseField1(request.getRequestField1() + "_updated");
        responsePojoSample.setResponseField2(request.getRequestField2() + "_updated");

        return responsePojoSample;
    }
}
