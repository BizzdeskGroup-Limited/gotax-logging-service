package com.bizzdesk.gotax.logging.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "go_tax_logs")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class GoTaxLogs {

    @Id
    private String id;
    private String method;
    private String path;
    private Date requestDate;
    private String remoteAddress;
    private String httpStatusCode;
    private String urlParameters;
    private String fullRequestPath;
    private String requestHeaders;
    private String requestPayload;
    private String responsePayload;
}
