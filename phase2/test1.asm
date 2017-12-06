.data
	X:	.space 400
	Y:	.word 10,10,10...
	i:	.word 0
	sum:	.word 0
.text
.global
	main:	lw $t0, i
			addi $t1, $0, 100
			#Stack variables are most complicated to load
			#lw $t2, 5($sp)	#where 5 is #temps - current temp #
			brge $t0, $t1, end_loop
