///////////////////////////////////////////////////////
// RCA4.sv  This design will add two 4-bit vectors  //
// plus a carry in to produce a sum and a carry out//
////////////////////////////////////////////////////
module RCA4(
  input 	[3:0]	A,B,	// two 4-bit vectors to be added
  input 			Cin,	// An optional carry in bit
  output 	[3:0]	S,		// 4-bit Sum
  output 			Cout  	// and carry out
);

	/////////////////////////////////////////////////
	// Declare any internal signals as type logic //
	///////////////////////////////////////////////
	logic [2:0] Carrier;
	
	/////////////////////////////////////////////////
	// Implement Full Adder as structural verilog //
	///////////////////////////////////////////////
	FA FA0(.A(A[0]), .B(B[0]), .Cin(Cin), .S(S[0]), .Cout(Carrier[0]));
	FA FA1(.A(A[1]), .B(B[1]), .Cin(Carrier[0]), .S(S[1]), .Cout(Carrier[1]));
	FA FA2(.A(A[2]), .B(B[2]), .Cin(Carrier[1]), .S(S[2]), .Cout(Carrier[2]));
	FA FA3(.A(A[3]), .B(B[3]), .Cin(Carrier[2]), .S(S[3]), .Cout(Cout));

endmodule
