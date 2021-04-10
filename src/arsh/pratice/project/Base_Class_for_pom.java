package arsh.pratice.project;
/*Base class methods() 

	1.	Browser launch()
	2.	Close()
	3.	Quit()
	4.	Navigate to
	5.	Navigate back
	6.	Navigate forward 
	7.	Navigate refresh
	8.	Get 
	9.	Alert
	10.	Action
	11.	Frames
	12.	Robot
	13.	Window handles
	14.	Drop down 
	15.	Check box
	16.	Is enable
	17.	Is displayed
	18.	Is selected
	19.	Get options 
	20.	Get title
	21.	Get current url 
	22.	Get text 
	23.	Get attribute
	24.	Wait(3)
	25.	Take screenshot
	26.	Scroll up and down
	27.	Sendkeys
	28.	Get first selected options()
	29.	Get all selected options()
	30.	Is multiple()
	31.	Click()  
	32. maxzimise()                                                                                                  */
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class_for_pom {
	public static WebDriver driver;
	
	public static WebDriver browserLanuch(String browsername) {
	  
		try {
			if (browsername.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\driver\\chromedriver.exe ");
				driver= new ChromeDriver();
			}else if (browsername.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driver\\geckodriver.exe");
				driver= new FirefoxDriver();			
			}else if (browsername.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\driver\\IEDriverServer.exe");
			    driver=new InternetExplorerDriver();			    
			}else if (browsername.equalsIgnoreCase("msedge")) {
				System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\driver\\msedgedriver.exe");
			    driver=new EdgeDriver();		    
			}else {
				System.out.println("browser name is invalid");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;	
	}
	
		 
		 
	
	
	public static void Maxzimize() {
		driver.manage().window().maximize();
	}
	
	public static void getcurrenturl() {
	System.out.println(driver.getCurrentUrl());	
	}
	
	public static void getcurrenttitle() {
		System.out.println(driver.getTitle());
	}
	
	public static void sleep(int Duration) throws InterruptedException {
		Thread.sleep(Duration);
	}
	public static void click(WebElement webElement) {
		WebElement c = webElement;
		c.click();
	}
	
	public static void sendkeys(WebElement webElement,String Text) {
		WebElement sendkeys = webElement;
		sendkeys.sendKeys(Text);
	}

    public static void close() {
    	driver.close();
    }
    public static void quit() {
		driver.quit();
	}
    
    
    
    
  
  
    //=====================navigate to================//
    
	public static void navigate_To(String option) {
		driver.navigate().to(option);
	}
	
	public static void navigate_back() {
		driver.navigate().back();
	}
	
	public static void navigate_forward() {
		driver.navigate().forward();
	}
	
	public static void navigate_refresh() {
		driver.navigate().refresh();
	}
	
	
	//=====================Get====================//
	
	public static void GetUrl(String url) {
		driver.get(url);
		
    }
	
	public static void getoptions(WebElement path,String value) {
		try {
			WebElement options = path;
			Select s = new Select(options);
			
			List<WebElement> options2 = s.getOptions();
			for (WebElement getoptions : options2) {
				if (value.equalsIgnoreCase("text")) {
					System.out.println(getoptions.getText());
				}else if (value.equalsIgnoreCase("value")) {
					System.out.println(getoptions.getAttribute(value));
				}else if (value.equalsIgnoreCase("tagname")) {
					System.out.println(getoptions.getTagName());
				}else if (value.equalsIgnoreCase("cssvalue")) {
					System.out.println(getoptions.getCssValue(value));
				}else {
					System.out.println("invalid format");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public static void getselectedoptions(WebElement path,String getby) {
		 WebElement by = path;
		    
		Select s = new Select(by);       
		List<WebElement> all = s.getAllSelectedOptions();
        for (WebElement a : all) {
			if (getby.equalsIgnoreCase("text")) {
				System.out.println(a.getText());				
			}else if (getby.equalsIgnoreCase("tagname")) {
				System.out.println(a.getTagName());
			}
		}
	}
	
	public static void alert(String type) {
		Alert a = driver.switchTo().alert();
		
		if (type.equalsIgnoreCase("ok")) {
			a.accept();
		}else if (type.equalsIgnoreCase("cancel")) {
			a.dismiss();
		}else {
			System.out.println("type valid key");
		}
		
	}
	
	public static void alertsendkey(String add,String clickbutton) {
		
        Alert b = driver.switchTo().alert();
		b.sendKeys(add);
		if (clickbutton.equalsIgnoreCase("ok")) {
			b.accept();
		}else if (clickbutton.equalsIgnoreCase("cancel")) {
			b.dismiss();
		}else {
			System.out.println("invalid");
		}
	}
	
	public static void Action(String click_by,WebElement target_by) {
		WebElement action = target_by;
		Actions a = new Actions(driver);
		if (click_by.equalsIgnoreCase("rightclick")) {
			a.contextClick().build().perform();
		}else if (click_by.equalsIgnoreCase("rightclicktarget")) {
			a.contextClick(action).build().perform();
		}
		else if (click_by.equalsIgnoreCase("movetoandclick")) {
			a.moveToElement(action).click().build().perform();
		}else if (click_by.equalsIgnoreCase("Doubleclick")) {
			a.doubleClick(action).build().perform();
		}

	}
	
	public static void Frame(String id_or_index,String path ) {
		
		if (id_or_index.equalsIgnoreCase("index")) {
			driver.switchTo().frame(Integer.parseInt(path));
		}else if (id_or_index.equalsIgnoreCase("id")) {
			driver.switchTo().frame(path);
		}else {
			System.out.println("invalid frame format");
		}
	}
	public static void Framebyelement(WebElement elementname) {
		 
			driver.switchTo().frame(elementname);
		
	}
		
		public static void Frame_out(String parent_default){
			
		if (parent_default.equalsIgnoreCase("parentframe")) {
			driver.switchTo().parentFrame();
		}else if (parent_default.equalsIgnoreCase("default")) {
			driver.switchTo().defaultContent();
		}else {
			System.out.println("only--(parentframe,default ) is valid");
		}
		
	}
	
	public static void scroll_to_target(WebElement path) {
		 WebElement scroll = path;
		    JavascriptExecutor js = (JavascriptExecutor)driver;
		    js.executeScript("arguments[0].scrollIntoView(true)", scroll);
	}
	public static void scrolldown(int  min_value_100) {
		
           for (int i = 100; i <=min_value_100; i = i + 100) {
        		JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("window.scrollBy(0,100)");
             
		}
   	}
	public static void scrollup(int  min_value_100) {
		for (int i = 100; i <=min_value_100; i = i + 100) {
    		JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,-100)");
	}
		
	
}
	public static void screenshot(String Destination_and_filename ) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
	    File screen = ts.getScreenshotAs(OutputType.FILE);
	    File destination = new File(Destination_and_filename);
        FileUtils.copyFile(screen, destination);
	}
	
	 public static void dropdown(WebElement path,String options,String value) {
		WebElement element = path;
		 Select s = new Select(element);
		 if (options.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(value));
		}else if (options.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		}else if (options.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		}
	 }
	 
	 public static void Is_Multiple(WebElement path) {
			WebElement element = path;
			 Select s = new Select(element);
			 System.out.println(s.isMultiple());
		 }
	 
	 public static void keyup(byte how_many_times ) throws AWTException {
		for (int i = 1; i <=how_many_times ; i++) {
    		Robot r = new Robot();
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
	 }			
		}
	 public static void keydown(byte how_many_times) throws AWTException {
	
		 for (int i = 1; i <=how_many_times ; i++) {
	    		Robot r = new Robot();
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
}
}
	 public static void Enterkey() throws AWTException {
		 Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			
	 }
	 
	 public static void close_windows(String tab_name) {
		 Set<String> all_id = driver.getWindowHandles();
		    
		    for (String id : all_id) {
		    	
				String title = driver.switchTo().window(id).getTitle();
				System.out.println(title);
				
				if (driver.switchTo().window(id).getTitle().equals(tab_name)) {
					driver.close();
				}
			}
	 }
}









































