package arsh.pratice.project;

import org.openqa.selenium.WebDriver;

public class Adictin_Main extends Base_Class_for_pom{
public static WebDriver driver;
public static void main(String[] args) throws InterruptedException {
	driver=browserLanuch("chrome");
	GetUrl("http://adactinhotelapp.com/index.php");
	LogIn_Page l = new LogIn_Page(driver);
	
	//==========Login page=========//
	
	sendkeys(l.getUsername(),"SowmiyaSri");
	sendkeys(l.getPassword(), "Sowmiya05");
	click(l.getLogin());
	
	//==========Search hotel=======//
	
	Search_hotel s = new Search_hotel(driver);
	dropdown(s.getLocation(), "text", "Sydney");
	dropdown(s.getHotels(), "text", "Hotel Sunshine");
	dropdown(s.getRoomtype(),"text", "Deluxe");
	dropdown(s.getRoom_nos(),"text","2 - Two");
	sendkeys(s.getDatepick_in(),"10/3/2021");
	sendkeys(s.getDatepick_out(),"15/3/2021");
	dropdown(s.getAdult_room(), "text", "2 - Two");
	click(s.getSubmit());
	
	//===============Confirmation page============//
	
	Conformation_Page n = new Conformation_Page(driver);
	
	click(n.getRadiobutton_0());
	click(n.getContinue1());
	sendkeys(n.getFirst_name(), "Arsath");
	sendkeys(n.getLast_name(), "Mohamed");
	sendkeys(n.getAddress(),"hai how are u");
	sendkeys(n.getCc_num(),"1234567890");
	dropdown(n.getCc_type(), "text", "American Express");
	dropdown(n.getCc_exp_month(),"text", "March");
	dropdown(n.getCc_exp_year(),"text","2011");
	sendkeys(n.getCc_cvv(),"230");
	click(n.getBook_now());
	alert("ok");
	click(n.getLogout());
	//sleep(5000);
	//quit();
	
	
}

}
