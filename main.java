//importing sql package
import java.sql.*;
import java.util.*;
import java.io.Console;

class main
{
	public static void cls()
	{
        try
        {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
	public static void main(String[] args)
	{
		//defining variables
		//general variable
		String uname;
		String passwd;
		String query;
		int option;
		int row;
		Scanner sc = new Scanner(System.in);
		Console cnsl = System.console();
		String nul;
		int tempTotalLoan = 0;

		//share holder class variable
		int sid;	
		String name;
		String dob;
		String issueDate;
		String address;
		String idProofName;
		String idProofNumber;
		String refrence;
		
		//loan department class variable
		int loanNo;
		int loanAmount;
		int intrest;
		int tempIntrest = 0;
		int tempIntrestAmount = 0;
		int totalAmount;
		String choice;



		//getting username and password
		System.out.print("Enter Username : ");
		uname = sc.nextLine();

		char[] pwd = cnsl.readPassword("Password: ");
      	passwd = new String(pwd);
		try
		{
			//verifying username and password
			conn cn = new conn();
			ResultSet rs = cn.s.executeQuery("select * from login where uname ='"+uname+"' and passwrd ='"+passwd+"' ;");
			if(rs.next())
			{
				do
				{
					cls();
					System.out.println("--------------------------------------------------------------------");
					System.out.println("---------------------Welcome To Credit Soc.-------------------------");
					System.out.println("--------------------------------------------------------------------");
					
					System.out.println("|-> 1.Share Holder");
					System.out.println("|-> 2.Loan Department");
					System.out.println("|-> 3.Day Book");
					System.out.println("|-> 4.Final Account");
					System.out.println("|-> 0.Exit");
					System.out.println("--------------------------------------------------------------------");
					System.out.print("Enter Option : ");
					option = sc.nextInt();

					
					switch(option)
					{
						case 1:
						cls();
						System.out.println("=====================================================================");
						System.out.println("======================Share Holder Department========================");
						System.out.println("=====================================================================");
						
						System.out.println("|-> 1.Add new Share Holder");
						System.out.println("|-> 2.Edit Share Holder Detils");
						System.out.println("|-> 3.Share View");
						System.out.println("--------------------------------------------------------------------");
						System.out.print("Enter Choice : ");
						option = sc.nextInt();
						
						System.out.println("--------------------------------------------------------------------");
						switch(option)
						{
							//Adding new share holder
							case 1:
							cls();	
							System.out.println("-----------------------------------------------------------------");
							System.out.println("======================Add New Share Holder=======================");
							System.out.println("-----------------------------------------------------------------");		
							do
							{
								System.out.print("Enter New Share Id:");
								sid = sc.nextInt();
								rs = cn.s.executeQuery("select * from shareHolder where sid = '"+sid+"';");
								if(rs.next())
								{
									System.out.println("--------------------------------------------------------------------");
									System.out.println(" Sorry Share Id Exist Try Different. :(");
									System.out.println("--------------------------------------------------------------------");
									System.out.print("Enter 0 to go Back:");
									nul = sc.next();
								}
								else
								{
									nul = sc.nextLine();
									System.out.print("Enter Full Name : ");
									name = sc.nextLine();

									System.out.print("Enter Date Of Birth (YYYY-MM-DD) : ");
									dob = sc.nextLine();

									System.out.print("Enter Issue Date (YYYY-MM-DD) : ");
									issueDate = sc.nextLine();;

									System.out.print("Enter Id Proof : ");
									idProofName = sc.nextLine();

									System.out.print("Enter Id Proof Unique Id Number : ");
									idProofNumber = sc.nextLine();

									System.out.print("Enter Refrence Person Name (Enter Null if no one is In refrence) : ");
									refrence = sc.nextLine();

									System.out.print("Enter Address : ");
									address = sc.nextLine();

									System.out.println("---------------------------------------------------------------------");
									query = "insert into shareHolder values("+sid+",'"+name+"','"+dob+"','"+issueDate+"','"+address+"','"+idProofName+"','"+idProofNumber+"','"+refrence+"');";
									row = cn.s.executeUpdate(query);		
									System.out.println(row + " Person Added");
									System.out.println("--------------------------------------------------------------------");
									System.out.print("Enter 0 to go Back:");
									nul = sc.next();
									break;
								}
							}
							while(!rs.next());
							break;
							
							case 2:
							cls();
							System.out.println("-----------------------------------------------------------------");
							System.out.println("====================Edit Share Holder Detail=====================");
							System.out.println("-----------------------------------------------------------------");
								System.out.print("Enter Share Id:");
								sid = sc.nextInt();
								rs = cn.s.executeQuery("select * from shareHolder where sid = '"+sid+"';");
								if(!rs.next())
								{
									System.out.println(" Sorry Share Id Doesn't Exist. :( ");
								}
								else
								{
									System.out.println("-----------------------------------------------------------------");
									System.out.println("|-> 1.Change Name. ");
									System.out.println("|-> 2.Change Date Of Birth.");
									System.out.println("|-> 3.Change Address.");
									System.out.println("|-> 4.Change Id Proof.");
									System.out.println("|-> 5.Change Id Proof Unique Number.");
									System.out.println("|-> 6.Change Refrence Person.");
									System.out.println("-----------------------------------------------------------------");
									System.out.print("Enter Your Choice : ");
									option = sc.nextInt();
									System.out.println("-----------------------------------------------------------------");
									switch(option)
									{
										case 1:
											System.out.print("Enter New Name: ");
											name = sc.next();
											query = "update shareHolder set name ='"+name+"' where sid = '"+sid+"' ;";
											row = cn.s.executeUpdate(query);		
											System.out.println("-----------------------------------------------------------------");
											System.out.println(row + " Person Detail Updated");
											System.out.println("-----------------------------------------------------------------");
											System.out.print("Enter 0 to go Back:");
											nul = sc.next();
										break;
										case 2:
											System.out.print("Enter New Date Of Birth: ");
											dob = sc.next();
											query = "update shareHolder set dob ='"+dob+"' where sid = '"+sid+"' ;";
											row = cn.s.executeUpdate(query);		
											System.out.println(row + " Person Detail Updated");
											System.out.println("-----------------------------------------------------------------");
											System.out.print("Enter 0 to go Back:");
											System.out.println("-----------------------------------------------------------------");
											nul = sc.next();
										break;
										case 3:
											System.out.print("Enter New Address: ");
											address = sc.next();
											query = "update shareHolder set address ='"+address+"' where sid = '"+sid+"' ;";
											row = cn.s.executeUpdate(query);		
											System.out.println("-----------------------------------------------------------------");
											System.out.println(row + " Person Detail Updated");
											System.out.println("-----------------------------------------------------------------");
											System.out.print("Enter 0 to go Back:");
											nul = sc.next();
										break;
										case 4:
											System.out.print("Enter New Id Proof: ");
											idProofName = sc.next();
											query = "update shareHolder set idproofname ='"+idProofName+"' where sid = '"+sid+"' ;";
											row = cn.s.executeUpdate(query);		
											System.out.println("-----------------------------------------------------------------");
											System.out.println(row + " Person Detail Updated");
											System.out.println("-----------------------------------------------------------------");
											System.out.print("Enter 0 to go Back:");
											nul = sc.next();
										break;
										case 5:
											System.out.print("Enter New Id Proof Unique Number: ");
											idProofNumber = sc.next();
											query = "update shareHolder set idproofnum ='"+idProofNumber+"' where sid = '"+sid+"' ;";
											row = cn.s.executeUpdate(query);		
											System.out.println("-----------------------------------------------------------------");
											System.out.println(row + " Person Detail Updated");
											System.out.println("-----------------------------------------------------------------");
											System.out.print("Enter 0 to go Back:");
											nul = sc.next();
										break;
										case 6:
											System.out.print("Enter New Refrence Person: ");
											refrence = sc.next();
											query = "update shareHolder set refrence ='"+refrence+"' where sid = '"+sid+"' ;";
											row = cn.s.executeUpdate(query);		
											System.out.println("-----------------------------------------------------------------");
											System.out.println(row + " Person Detail Updated");
											System.out.println("-----------------------------------------------------------------");
											System.out.print("Enter 0 to go Back:");
											nul = sc.next();
										break;
										default:
											System.out.println("Enter A Valid Choice..");
										break;
										
									}
								}
							break;

							case 3:
								cls();
								System.out.println("-------------------------------------------------------------------");
								System.out.println("=====================View Share Holder Detail======================");
								System.out.println("-------------------------------------------------------------------");
								System.out.print("Enter Share Id:");
								sid = sc.nextInt();
								rs = cn.s.executeQuery("select * from shareHolder where sid = '"+sid+"';");
								if(!rs.next())
								{
									System.out.println(" Sorry Share Id Doesn't Exist. :( ");
								}
								else
								{
									System.out.println("-------------------------------------------------------------------");
									System.out.println("|-> Name : "+rs.getString(2));
									System.out.println("|-> Date Of Birth : "+rs.getString(3));
									System.out.println("|-> Issue Date : "+rs.getString(4));
									System.out.println("|-> Address : "+rs.getString(5));
									System.out.println("|-> Id Proof  : "+rs.getString(6));
									System.out.println("|-> Id Proof Unique Number : "+rs.getString(7));
									System.out.println("|-> Refrence Person : "+rs.getString(8));
									System.out.println("-------------------------------------------------------------------");
									System.out.print("Enter 0 to go Back:");
									nul = sc.next();
								}
							break;
						}
						break;
						
						case 2:
							cls();
							System.out.println("=====================================================================");
							System.out.println("==========================Loan Department============================");
							System.out.println("=====================================================================");	
							
							System.out.println("1.New Loan.");
							System.out.println("2.Close Loan.");
							System.out.print("Enter Choice : ");
							option = sc.nextInt();
							
							System.out.println("--------------------------------------------------------------------");
							switch(option)
							{
								
								//Adding new loan
								case 1:
								cls();
								System.out.println("-----------------------------------------------------------------");
								System.out.println("============================New Loan=============================");
								System.out.println("-----------------------------------------------------------------");		
								do
								{
									System.out.print("Enter Share Id:");
									sid = sc.nextInt();
									rs = cn.s.executeQuery("select * from shareHolder where sid = '"+sid+"';");
									if(!rs.next())
									{
										System.out.println(" Sorry Share Id Doesn't Exist. :(");
									}
									else
									{
										//nul = sc.nextLine();
										System.out.print("Enter New Loan No: ");
										loanNo = sc.nextInt();

										System.out.print("Enter Loan Amount : ");
										loanAmount = sc.nextInt();

										System.out.print("Enter Intrest Persantage : ");
										intrest = sc.nextInt();

										tempIntrestAmount = (loanAmount*intrest)/100;
										System.out.println("Total Payable Amount : "+tempIntrestAmount);

										tempIntrest = (loanAmount+(loanAmount*intrest)/100);	
										System.out.println("Total Payable Amount : "+tempIntrest);

										System.out.println("-----------------------------------------------------------------");
										query = "insert into loanDep(sid,loanNo,loanAmount,intrest,payableAmount,intrestAmount) values("+sid+","+loanNo+","+loanAmount+","+intrest+","+tempIntrest+","+tempIntrestAmount+");";
										row = cn.s.executeUpdate(query);		
										System.out.println(row + " Loan Added");
										System.out.println("-----------------------------------------------------------------");
										System.out.print("Enter 0 to go Back:");
										nul = sc.next();
										break;
									}
								}
								while(!rs.next());
								break;

								case 2:
									System.out.println("-----------------------------------------------------------------");
									System.out.println("===========================Close Loan============================");
									System.out.println("-----------------------------------------------------------------");		
									System.out.print("Enter Loan Number:");
									loanNo = sc.nextInt();
									rs = cn.s.executeQuery("select shareHolder.sid,loanDep.loanNo,shareHolder.name,shareHolder.dob,shareHolder.refrence,loanDep.loanAmount,loanDep.intrest,loanDep.intrestAmount,loanDep.payableAmount,loanDep.loandate from shareHolder inner join loanDep on shareHolder.sid = loanDep.sid where loanDep.loanNo = "+loanNo+";");
									if(!rs.next())
									{
										System.out.println(" Sorry Loan No Doesn't Exist Enter Valid Number :( ...");
									}
									else
									{
										System.out.println("|-------------------------------------------------------");
										System.out.println("|-> Your Share Id : "+rs.getInt(1));
										System.out.println("|-> Your Loan Number : "+rs.getInt(2));
										System.out.println("|-> Your Name : "+rs.getString(3));
										System.out.println("|-> Your Birth Date : "+rs.getString(4));
										System.out.println("|-> Your Refrence Person : "+rs.getString(5));
										System.out.println("|-> Your Loan Amount : "+rs.getInt(6));
										System.out.println("|-> Your Intrest Persantage: "+rs.getInt(7)+"%");
										System.out.println("|-> Your Intrest Amount: "+rs.getInt(8));
										System.out.println("|-> Your Total Payable Amount : "+rs.getInt(9));
										System.out.println("|-> Loan Issue Date : "+rs.getString(10));
										System.out.println("|-------------------------------------------------------");
										
										System.out.print("Do you Want To Close Loan (Y/N) : ");
										choice = sc.next();

										switch(choice)
										{
											case "Y","y":
											query = "Delete from loanDep where loanNo = "+loanNo+"";
											row = cn.s.executeUpdate(query);
											System.out.println(row +" Loan Canceled");
											
											case "N","n":
												break;

											default:
												System.out.println("Enter a valid Option......");
										}
									}
									System.out.println("-----------------------------------------------------------------");
										System.out.print("Enter 0 to go Back:");
										nul = sc.next();
								break;
							}
						break;

						case 3:  
							cls();
							System.out.println("=====================================================================");
							System.out.println("==============================Day Book===============================");
							System.out.println("=====================================================================");
							
							System.out.print("Enter the date (YYYY-MM-DD): ");
							String date = sc.next();
							
							rs = cn.s.executeQuery("select count(sid) from shareHolder where issueDate = '"+date+"';");
							while(rs.next())
							{
								System.out.println("|-> Share Fund on "+date+" : "+1650*(rs.getInt(1)));
							}
							rs = cn.s.executeQuery("select loanAmount from loanDep where loandate = '"+date+"';");
							while(rs.next())
							{
								tempTotalLoan += rs.getInt(1);
								//System.out.println("Loan Fund on "+date+" : "+ tempTotalLoan);
							}
							System.out.println("|-> Loan Fund on "+date+" : "+ tempTotalLoan);
							
							nul = sc.next();
						break;

						case 4:
							System.out.println("=====================================================================");
							System.out.println("===========================Final Account=============================");
							System.out.println("=====================================================================");
							
							rs = cn.s.executeQuery("select count(sid) from shareHolder ;");
							while(rs.next())
							{
								System.out.println("|-> Total Share Fund : "+1650*(rs.getInt(1)));
							}
							rs = cn.s.executeQuery("select loanAmount from loanDep;");
							while(rs.next())
							{
								tempTotalLoan += rs.getInt(1);
								//System.out.println("Loan Fund on "+date+" : "+ tempTotalLoan);
							}
							System.out.println("|-> Total Loan Fund : "+ tempTotalLoan);
							System.out.println("-----------------------------------------------------------------");
							System.out.print("Enter 0 to go Back:");
							nul = sc.next();
						break;
					}
				}
				while(option != 0);
			}
			else
			{
				System.out.println("Invalid User");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}