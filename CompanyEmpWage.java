package bridgelabz.JavaSamples;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public interface IComputeEmpWage {
	public void addCompanyEmpWage(String company, int empRatePerHour,
			int numOfWorkingDays, int maxHoursPerMonth);
	public void computeEmpWage();
	public int getTotalWage(String company);
	
}

public class CompanyEmpWage {
	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maxHoursPerMonth;
	public int totalEmpWage;
	
	public CompanyEmpWage(String company, int empRatePerHour,
			int numOfWorkingDays, int maxHoursPerMonth) {
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
		totalEmpWage = 0;
		}
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}
	@Override
	public String toString() {
		return "Total Emp Wage for Company: " +company+" is: "+
	totalEmpWage;
	}
}

public class EmpWageBuilder implements IComputeEmpWage {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	
	private int numOfCompany = 0;
	private LinkedList<CompanyEmpWage> companyEmpWageList;
	private Map<String,CompanyEmpWage> companyToEmpWageMap;
	private int empRatePerHour;
	
	public EmpWageBuilder() {
		companyEmpWageList = new LinkedList<>();
		companyToEmpWageMap = new HashMap<>();
	}
	
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays,
				maxHoursPerMonth);
		companyEmpWageList.add(companyEmpWage);
		companyToEmpWageMap.put(company, companyEmpWage);
	}
	
	public void computeEmpWage() {
		for (int i = 0; i < companyEmpWageList.size(); i++) {
			CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}
	@Override
	public int getTotalWage(String company) {
		return companyToEmpWageMap.get(company).totalEmpWage;
	}
	public int computeEmpWage(CompanyEmpWage companyEmpWage) {
		public static void main(String[] args) {
			IComputeEmpWage empWageBuilder = new EmpWageBuilder();
			int numOfWorkingDays;
			int maxHoursPerMonth;
			String company;
			empWageBuilder.addCompanyEmpWage( company: "DMart", empRatePerHour: 20, numOfWorkingDays: 2, maxHoursPerMonth);
			empWageBuilder.addCompanyEmpWage( company: "Relinance", empRatePerHour: 10, numOfWorkingDays: 4,  maxHoursPerMonth: 20);
			empWageBuilder.computeEmpWage();
			System.out.println("Total Wage for DMart Company: " + empWageBuilder.getTotalWage( company: "DMart"));
		}
	
		
	}
}
