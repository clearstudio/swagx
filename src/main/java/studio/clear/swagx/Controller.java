package studio.clear.swagx;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import studio.clear.swagx.utils.FileUtil;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.io.File;
import java.io.IOException;

/**
 * @author tkc
 * @version 1.0
 * @date 2020/7/3 13:37
 */
@RestController
public class Controller {
    @GetMapping("download")
    public void getSwaggerDocx(@NotBlank String api, HttpServletResponse response) throws IOException {
        Swagx.testSwaggerToWord(api);
        String tempFileDir = new ApplicationHome(Swagx.class).getSource().getParentFile().toString() + "/temp";
        String tempFilePath = tempFileDir + File.separator + "swagger_output.docx";
        FileUtil.downloadFile(tempFilePath,
                Swagx.fileName + ".docx", response);
        new File(tempFilePath).delete();
    }
}
