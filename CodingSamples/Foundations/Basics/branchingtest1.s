	.include "common.i"

	.start

	GetInt	askl			#rax=M
	GetInt	asku, rdi		#rdi=N

	cmp	rax, rdi
	jg	over			#branch to over if in previous comparison
					#first operand is greater than second operand

	sub	rax, 1			#rax=M-1
	mov	rbx, rax
	add	rbx, 1
	mul	rbx
	shr	rax, 1			#rax=L

	xchg	rax, rdi		#rax=N, rdi=L
	mov	rbx, rax
	add	rbx, 1
	mul	rbx
	shr	rax, 1			#rax=U
	sub	rax, rdi		#rax=S

	PutInt	tell<F3>

over:	PutStr	done
	
	.stop

askl:	.string	"Lower Limit: "
asku:	.string "Upper Limit: "
tell:	.string	"Computation Result = "
done:	.string	"Goodbye.\n\n"

	.end

