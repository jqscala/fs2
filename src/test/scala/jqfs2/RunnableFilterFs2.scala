package jqfs2

import io.circe.Json
import cats.effect.unsafe.implicits.global
import fs2.Stream
import cats.effect.IO

import jq._
import jq.std.given

given Fs2Run: RunnableFilter[Filter[IO], Json] with

    extension [A](st: Stream[IO, A])
        def run: List[A] = 
            st.compile.toList.unsafeRunSync()
            
    extension (input: List[Json])
        def throughJson(r: Filter[IO]): List[Json | TypeError[Json]] = 
            r(Stream[IO, Json](input*))
                .run

