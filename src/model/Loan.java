package model;

import java.time.LocalDate;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "loans")
@Getter @Setter
public class Loan {
	
	@Id
	@Column(name = "user_on_loan")
	private User onLoanTo;
	@Column(name = "article")
	private Article articleOnLoan;
	@Column(name = "loan_start")
	private LocalDate loanStart;
	@Column(name = "expected_loan_end")
	private LocalDate loanExpectedEnd;
	@Column(name = "actual_loan_end")
	private LocalDate loanActualEnd;
	
	public Loan() {
		super();
	}

	public Loan(User onLoanTo, Article articleOnLoan, LocalDate loanStart, LocalDate loanExpectedEnd,
			LocalDate loanActualEnd) {
		super();
		this.onLoanTo = onLoanTo;
		this.articleOnLoan = articleOnLoan;
		this.loanStart = loanStart;
		this.loanExpectedEnd = loanExpectedEnd;
		this.loanActualEnd = loanActualEnd;
	}
	
}
