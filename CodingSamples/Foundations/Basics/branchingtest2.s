	.include "common.i"

	.start

1:	GetInt	askl			#rax=M
	GetInt	asku, rdi		#rdi=N

	cmp	rax, rdi
	jg	1b			
	je	1f

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

1:	PutInt	tell

over:	PutStr	done
	
	.stop

askl:	.string	"Lower Limit: "
asku:	.string "Upper Limit: "
tell:	.string	"Computation Result = "
done:	.string	"Goodbye.\n\n"

	.end

