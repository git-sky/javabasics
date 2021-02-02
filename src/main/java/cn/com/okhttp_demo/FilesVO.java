package cn.com.okhttp_demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilesVO {
    private Long userId;

    private String name;

    private String savePath;
}