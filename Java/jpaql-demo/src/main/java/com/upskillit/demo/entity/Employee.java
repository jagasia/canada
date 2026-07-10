package com.upskillit.demo.entity;
import jakarta.persistence.*;import lombok.*;@Entity @Data @NoArgsConstructor
public class Employee{@Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;String name;String department;Double salary;}