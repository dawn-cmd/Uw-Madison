////////////////////////////////////////////////////////
// RCA16.sv  This design will add two 16-bit vectors //
// plus a carry in to produce a sum and a carry out //
/////////////////////////////////////////////////////
module RCA16(
  input 	[15:0]	A,B,	// two 16-bit vectors to be added
  input 			Cin,	// An optional carry in bit
  output 	[15:0]	S,		// 16-bit Sum
  output 			Cout  	// and carry out
);

	/////////////////////////////////////////////////
	// Declare any internal signals as type logic //
	///////////////////////////////////////////////
	logic [15:0] CarryOut;	// this is driven by .Cout of FA and will
							// in a "promoted" form drive .Cin of FA's
	logic [15:0] CarryIn;

	assign CarryIn = {CarryOut[14:0], Cin};
	assign Cout = CarryOut[15];

	// Instantiate 16-bit full adders using vectored instantiation
	FA fa[15:0] (.A(A), .B(B), .Cin(CarryIn), .S(S), .Cout(CarryOut));

endmodule
