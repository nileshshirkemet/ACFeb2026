	.include "common.i"

	.extern	lcm	#lcm symbol is defined in an external module

	.start

	GetInt	askn, rdi
	GetInt	askn, rsi
	call	lcm
	PutInt	tell

	.stop

askn:	.string	"Positive Integer: "
tell:	.string	"L.C.M = "

	.end

