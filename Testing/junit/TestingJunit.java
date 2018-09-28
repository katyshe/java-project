//package junit;
//
//import control.GameControl;
//import control.Main;
//import control.PlayerInGame;
//import model.Answer;
//import model.Board;
//import model.Player;
//import model.Question;
//import model.SysData;
//
//public class TestingJunit {
//	private static Main main ;
//	private static GameControl gc;
//	private static PlayerInGame pg;
//    private static Board g;
//    private static Player p;
//    private static Player p2;
//    private static Player p3;
//    private static Player p4;
//    private static Question q;
//    private static Answer A1;
//    private static Answer A2;
//    private static SysData sys;
//
//
////	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		main = new Main();
//		sys= SysData.getInstance();
//		 g = new Board();
//	 p = new Player("katy", "1");
//	 p2 = new Player("asala", "2");
//	 p3 = new Player("sham", "3");
//	 p4 = new Player("rana", "4");
//		gc = new GameControl(g);
//		q= new  Question("Ques1",0,false, "crocodile");
//	    A1.setText("Aswer1");
//	    A1.setIsCorrect(true);
//	    A2.setText("Answer2");
//	    A2.setIsCorrect(false);
//	    q.addOption(A1.getText(),A1.getIsCorrect());
//	    q.addOption(A2.getText(), A2.getIsCorrect());
//	    pg = new PlayerInGame(g, p);
//}
////
////	@AfterClass
////	public static void tearDownAfterClass() throws Exception {
//////		GC.removeQuestion(q);
//////		Main.removePlayer(p);
////		main = null;
////		GC = null;
////		sys = null;
////		
////	}
////
////
////
////	@Test
////	public void testProgrammerSaveCodeSegmentConnectPlayerToGame() {
////		//suppose to succeed
//////		sys.addNewUser(p);
////		
////		boolean res = GC.connectNewPlayer(p);
////
////		assertEquals("testing programmerSaveCodeSegment", true, res);
////		//suppose to fail because this player is not exist
////		boolean res2 = GC.connectNewPlayer(new Player("abeer", "456456"));
////		assertEquals("testing programmerSaveCodeSegment", false, res2);
////		
////	} 
//}
