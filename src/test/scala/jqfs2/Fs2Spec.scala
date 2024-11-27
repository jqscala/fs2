package jqfs2

import jq._
import jq.std.given
import cats.effect.IO

class Fs2Spec extends JqSpec[Filter[IO], io.circe.Json]