package relationship.building.action;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import relationship.building.dto.EmployeesViewDto;
import relationship.building.dto.EmployeesViewDto.EmployeesDto;
import relationship.building.dto.LoginDto;
import relationship.building.dto.TopViewDto.TopDto;
import relationship.building.entity.Employees;
import relationship.building.form.CreateForm;
import relationship.building.service.TopService;

public class TopAction {

	public EmployeesViewDto employeesViewDto;
	public EmployeesViewDto talkingParameter;
	public EmployeesViewDto isNotTalkingParameter;
	public EmployeesDto employeesDto;
	public Employees employees;
	public TopDto topDto = new TopDto();

	@ActionForm
	@Resource
	protected CreateForm createForm;

	public LoginDto loginDto;

	@Resource
	protected TopService topService;

	/**
 	* 入力画面
 	* @return
 	*/
	@Execute(validator = false)
	public String index() {
		//ダッシュボードを表示する

		List<Employees> employees = topService.findAll();
    	employeesViewDto = topService.findAllExceptDelete(employees);
    	talkingParameter = topService.findAllExceptStatus(employees);
    	isNotTalkingParameter = topService.findAllExcepNotStatus(employees);


        float talk = topService.calculator(talkingParameter.employeesDtos.size(),employeesViewDto.employeesDtos.size());
        float nontalk = topService.calculator(isNotTalkingParameter.employeesDtos.size(),employeesViewDto.employeesDtos.size());
        BigDecimal talkingparameter = new BigDecimal(talk);
        BigDecimal talking = talkingparameter.setScale(0, BigDecimal.ROUND_HALF_UP);
        BigDecimal nottalkingparameter = new BigDecimal(nontalk);
        BigDecimal nottalking = nottalkingparameter.setScale(0, BigDecimal.ROUND_HALF_UP);
        topDto.talk = talking;
        topDto.nontalk = nottalking;



        return "top.jsp";
	}
}


