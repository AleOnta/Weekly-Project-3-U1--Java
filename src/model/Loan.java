package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "loans")
public class Loan implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loan_id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User onLoanTo;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "article_id")
	private Article articleOnLoan;
	private LocalDate loan_start;
	@Column(name = "loan_exp_end")
	private LocalDate loanExpectedEnd;
	@Column(name = "loan_act_end", nullable = true)
	private LocalDate loanActualEnd;
	
	public Loan() {
		super();
	}


	public Loan(User onLoanTo, Article articleOnLoan, LocalDate loan_start, LocalDate loanActualEnd) {
		super();
		this.onLoanTo = onLoanTo;
		this.articleOnLoan = articleOnLoan;
		this.loan_start = loan_start;
		this.loanExpectedEnd = loan_start.plusMonths(1);
		this.loanActualEnd = loanActualEnd;
	}

	public User getOnLoanTo() {
		return onLoanTo;
	}

	public void setOnLoanTo(User onLoanTo) {
		this.onLoanTo = onLoanTo;
	}
	
	public Article getArticleOnLoan() {
		return articleOnLoan;
	}

	public void setArticleOnLoan(Article articleOnLoan) {
		this.articleOnLoan = articleOnLoan;
	}

	public LocalDate getLoan_start() {
		return loan_start;
	}

	public void setLoan_start(LocalDate loan_start) {
		this.loan_start = loan_start;
	}

	public LocalDate getLoanExpectedEnd() {
		return loanExpectedEnd;
	}

	public void setLoanExpectedEnd(LocalDate loanExpectedEnd) {
		this.loanExpectedEnd = loanExpectedEnd;
	}

	public LocalDate getLoanActualEnd() {
		return loanActualEnd;
	}

	public void setLoanActualEnd(LocalDate loanActualEnd) {
		this.loanActualEnd = loanActualEnd;
	}

	public Long getLoan_id() {
		return loan_id;
	}
	
}
