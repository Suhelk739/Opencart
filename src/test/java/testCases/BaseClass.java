package testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;



public class BaseClass {
	
	
	 public static  WebDriver driver;
	 public Logger logger;
	 public Properties p;
	 

	@BeforeClass(groups= {"Regression","Sanity"})
	@Parameters({"browser","OS"})
	 public void setUp(String br, String os) throws IOException {
		
		//reading config file:
		FileReader file=new FileReader("./src//test//resources//config.properties");// this class is used to read the file
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equals("remote")) {
			DesiredCapabilities cap=new DesiredCapabilities();
			
			//oS setup
			if(os.equalsIgnoreCase("windows")) {
				
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			
			}
			else if(os.equalsIgnoreCase("Linux")) {
				cap.setPlatform(Platform.LINUX);
				
			}
			else {
				System.out.println("OS is not correct");
				return;
			}
			
			//browser setup
			switch(br.toLowerCase()) {
			case "chrome": cap.setBrowserName("chrome"); break;
			case "edge":cap.setBrowserName("MicrosoftEdge"); break;
			case "firefox": cap.setBrowserName("firefox");break;
			default : System.out.println("browser is not correct"); return;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			
			
		}
		
		if(p.getProperty("execution_env").equals("local")) {
			switch(br) {
			
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default :System.out.println("browser is not valid"); return;
			}
		}
		
		

		
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Regression","Sanity"})
	void tesrDown(){
		driver.quit();
		
	}
	
	public String randomEmail() {
		String random_email=RandomStringUtils.randomAlphabetic(5);
		return random_email;
	}
	
	public String randomName() {
		String name=RandomStringUtils.randomAlphabetic(5);
		return name;
	}
	
	public String randomLname() {
		String Lname=RandomStringUtils.randomAlphabetic(4);
		return Lname;
	}
	
	public String passWord() {
		String pass=RandomStringUtils.randomAlphanumeric(5);
		return pass;
	}
	
	public String captureScreen(String name) {
		
		String timeStamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ss=(TakesScreenshot)driver;
		File SF=ss.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp + ".png";
		File TF=new File(path);
		SF.renameTo(TF);
		return path;
	}

}
