	.include "common.i"

gcd:	
1:	cmp	rdi, rsi
	je	3f
	jg	2f
	sub	rsi, rdi
	jmp	1b
2:	sub	rdi, rsi
	jmp	1b
3:	mov	rax, rdi
	ret


	.global	lcm		#lcm symbol is visible to external modules
	.type	lcm, %function	#lcm symbol identfies a function
lcm:	
	sub	rsp, 16		#making space for local variables
	mov	[rsp], rdi
	mov	[rsp+8], rsi
	call	gcd
	mov	rcx, rax
	mov	rdi, [rsp]
	mov	rsi, [rsp+8]
	mov	rax, rdi
	mul	rsi
	div	rcx
	add	rsp, 16		#unwinding stack frame
	ret


