# VacationPayCalculatorSpringBoot
A microservice used to calculate vacation pay. 
<br>
<br>
Has the only API: GET "/calculate".
<br>
<br>
Expects:<br>
<b>avg_salary</b> -  avg month salary for 12 months<br>
<b>number_of_days</b> - number of vacation days<br>
<b>first_day</b> - <i>optional</i>, first day of vacation, yyyy-mm-dd
<br>
<br>
Returns:<br>
amount of vacation pay (rounded to two decimal places).
<br>
<i> holidays are considered (using Russian calendar) if <b>first_day</b> is specified</i>
<br>
<br>
Example:<br>
/calculate?avg_salary=10000&number_of_days=14<br>
/calculate?avg_salary=25000&number_of_days=7&first_day=2023-01-01
<br>
<br>
Technologies: Java 11, SpringBoot 2.7.11 (Spring Web).