.globl main
.data
i: .word 0
sum: .word 0
X: .space 400
Y: .space 400

.text
main:
#array_assign
la $t0, X
addi $t1, $0, 10
sw $t1, 0($t0)
sw $t1, 4($t0)
sw $t1, 8($t0)
sw $t1, 12($t0)
sw $t1, 16($t0)
sw $t1, 20($t0)
sw $t1, 24($t0)
sw $t1, 28($t0)
sw $t1, 32($t0)
sw $t1, 36($t0)
sw $t1, 40($t0)
sw $t1, 44($t0)
sw $t1, 48($t0)
sw $t1, 52($t0)
sw $t1, 56($t0)
sw $t1, 60($t0)
sw $t1, 64($t0)
sw $t1, 68($t0)
sw $t1, 72($t0)
sw $t1, 76($t0)
sw $t1, 80($t0)
sw $t1, 84($t0)
sw $t1, 88($t0)
sw $t1, 92($t0)
sw $t1, 96($t0)
sw $t1, 100($t0)
sw $t1, 104($t0)
sw $t1, 108($t0)
sw $t1, 112($t0)
sw $t1, 116($t0)
sw $t1, 120($t0)
sw $t1, 124($t0)
sw $t1, 128($t0)
sw $t1, 132($t0)
sw $t1, 136($t0)
sw $t1, 140($t0)
sw $t1, 144($t0)
sw $t1, 148($t0)
sw $t1, 152($t0)
sw $t1, 156($t0)
sw $t1, 160($t0)
sw $t1, 164($t0)
sw $t1, 168($t0)
sw $t1, 172($t0)
sw $t1, 176($t0)
sw $t1, 180($t0)
sw $t1, 184($t0)
sw $t1, 188($t0)
sw $t1, 192($t0)
sw $t1, 196($t0)
sw $t1, 200($t0)
sw $t1, 204($t0)
sw $t1, 208($t0)
sw $t1, 212($t0)
sw $t1, 216($t0)
sw $t1, 220($t0)
sw $t1, 224($t0)
sw $t1, 228($t0)
sw $t1, 232($t0)
sw $t1, 236($t0)
sw $t1, 240($t0)
sw $t1, 244($t0)
sw $t1, 248($t0)
sw $t1, 252($t0)
sw $t1, 256($t0)
sw $t1, 260($t0)
sw $t1, 264($t0)
sw $t1, 268($t0)
sw $t1, 272($t0)
sw $t1, 276($t0)
sw $t1, 280($t0)
sw $t1, 284($t0)
sw $t1, 288($t0)
sw $t1, 292($t0)
sw $t1, 296($t0)
sw $t1, 300($t0)
sw $t1, 304($t0)
sw $t1, 308($t0)
sw $t1, 312($t0)
sw $t1, 316($t0)
sw $t1, 320($t0)
sw $t1, 324($t0)
sw $t1, 328($t0)
sw $t1, 332($t0)
sw $t1, 336($t0)
sw $t1, 340($t0)
sw $t1, 344($t0)
sw $t1, 348($t0)
sw $t1, 352($t0)
sw $t1, 356($t0)
sw $t1, 360($t0)
sw $t1, 364($t0)
sw $t1, 368($t0)
sw $t1, 372($t0)
sw $t1, 376($t0)
sw $t1, 380($t0)
sw $t1, 384($t0)
sw $t1, 388($t0)
sw $t1, 392($t0)
sw $t1, 396($t0)
#array_assign
la $t0, Y
addi $t1, $0, 10
sw $t1, 0($t0)
sw $t1, 4($t0)
sw $t1, 8($t0)
sw $t1, 12($t0)
sw $t1, 16($t0)
sw $t1, 20($t0)
sw $t1, 24($t0)
sw $t1, 28($t0)
sw $t1, 32($t0)
sw $t1, 36($t0)
sw $t1, 40($t0)
sw $t1, 44($t0)
sw $t1, 48($t0)
sw $t1, 52($t0)
sw $t1, 56($t0)
sw $t1, 60($t0)
sw $t1, 64($t0)
sw $t1, 68($t0)
sw $t1, 72($t0)
sw $t1, 76($t0)
sw $t1, 80($t0)
sw $t1, 84($t0)
sw $t1, 88($t0)
sw $t1, 92($t0)
sw $t1, 96($t0)
sw $t1, 100($t0)
sw $t1, 104($t0)
sw $t1, 108($t0)
sw $t1, 112($t0)
sw $t1, 116($t0)
sw $t1, 120($t0)
sw $t1, 124($t0)
sw $t1, 128($t0)
sw $t1, 132($t0)
sw $t1, 136($t0)
sw $t1, 140($t0)
sw $t1, 144($t0)
sw $t1, 148($t0)
sw $t1, 152($t0)
sw $t1, 156($t0)
sw $t1, 160($t0)
sw $t1, 164($t0)
sw $t1, 168($t0)
sw $t1, 172($t0)
sw $t1, 176($t0)
sw $t1, 180($t0)
sw $t1, 184($t0)
sw $t1, 188($t0)
sw $t1, 192($t0)
sw $t1, 196($t0)
sw $t1, 200($t0)
sw $t1, 204($t0)
sw $t1, 208($t0)
sw $t1, 212($t0)
sw $t1, 216($t0)
sw $t1, 220($t0)
sw $t1, 224($t0)
sw $t1, 228($t0)
sw $t1, 232($t0)
sw $t1, 236($t0)
sw $t1, 240($t0)
sw $t1, 244($t0)
sw $t1, 248($t0)
sw $t1, 252($t0)
sw $t1, 256($t0)
sw $t1, 260($t0)
sw $t1, 264($t0)
sw $t1, 268($t0)
sw $t1, 272($t0)
sw $t1, 276($t0)
sw $t1, 280($t0)
sw $t1, 284($t0)
sw $t1, 288($t0)
sw $t1, 292($t0)
sw $t1, 296($t0)
sw $t1, 300($t0)
sw $t1, 304($t0)
sw $t1, 308($t0)
sw $t1, 312($t0)
sw $t1, 316($t0)
sw $t1, 320($t0)
sw $t1, 324($t0)
sw $t1, 328($t0)
sw $t1, 332($t0)
sw $t1, 336($t0)
sw $t1, 340($t0)
sw $t1, 344($t0)
sw $t1, 348($t0)
sw $t1, 352($t0)
sw $t1, 356($t0)
sw $t1, 360($t0)
sw $t1, 364($t0)
sw $t1, 368($t0)
sw $t1, 372($t0)
sw $t1, 376($t0)
sw $t1, 380($t0)
sw $t1, 384($t0)
sw $t1, 388($t0)
sw $t1, 392($t0)
sw $t1, 396($t0)
#assign
addi $t0, $0, 0
sw $t0, i
#assign
addi $t0, $0, 0
sw $t0, sum
#label
main2:

#branch
lw $t0, i
addi $t1, $0, 100
bge	$t0, $t1, end_loop
#array_load
la $t0,  X
lw $t1, i
addi $t2, $0, 4
mult $t1, $t2
mflo $t3
add $t4, $t0, $t3
lw $t5, 0($t4)
sw $t5, 4($sp)
#array_load
la $t0,  Y
lw $t1, i
addi $t2, $0, 4
mult $t1, $t2
mflo $t3
add $t4, $t0, $t3
lw $t5, 0($t4)
sw $t5, 8($sp)
#mult
lw $t0, 4($sp)
lw $t1, 8($sp)
mult $t0, $t1
mflo $t2
sw $t2, 12($sp)
#add
lw $t1, sum
lw $t2, 12($sp)
add $t0, $t1, $t2
sw $t0, sum
#add
lw $t1, i
addi $t2, $0, 1
add $t0, $t1, $t2
sw $t0, i
#goto
j main2
#label
end_loop:

jr $ra
