
package com.canadalife.demo.document;
import org.springframework.data.annotation.Id;import org.springframework.data.mongodb.core.mapping.Document;import lombok.*;
@Document @Data @NoArgsConstructor @AllArgsConstructor
public class Employee{@Id private String id; private String name; private String department; private Double salary;}
