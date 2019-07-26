// See LICENSE for license details.

import chisel3._

/** 4 input multiplexer.
  * Select from among 0 - 3 using selector value.
  */
class Mux4 extends Module {
  val io = IO(new Bundle {
    val selector = Input(UInt(2.W))
    val in_0 = Input(UInt(1.W))
    val in_1 = Input(UInt(1.W))
    val in_2 = Input(UInt(1.W))
    val in_3 = Input(UInt(1.W))
    val out = Output(UInt(1.W))
  })

  io.out := Mux2(io.selector(1),
    Mux2(io.selector(0), io.in_0, io.in_1),
    Mux2(io.selector(0), io.in_2, io.in_3))
}

/**
  * Object to output Verilog file of Mux4.
  */
object Mux4 extends App {
  chisel3.Driver.execute(args, () => new Mux4())
}
