Projects uses Kotlin `1.9.24`, but depends on a library compiled with Kotlin `2.0.0-RC3`.

All targets except Wasm compiles fine:

```shell
./gradlew clean check
```

But for Wasm-targets, compilation fails:

```shell
./gradlew clean check -PwithWasm=true
```

```
> Task :compileTestDevelopmentExecutableKotlinWasmJs FAILED
e: java.lang.NullPointerException: null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor
    at org.jetbrains.kotlin.backend.wasm.WasmSymbols.findClass(WasmSymbols.kt:387)
    at org.jetbrains.kotlin.backend.wasm.WasmSymbols.getClass$backend_wasm(WasmSymbols.kt:396)
    at org.jetbrains.kotlin.backend.wasm.WasmSymbols.getIrClass(WasmSymbols.kt:416)
    at org.jetbrains.kotlin.backend.wasm.WasmSymbols.getInternalClass(WasmSymbols.kt:417)
    at org.jetbrains.kotlin.backend.wasm.WasmSymbols.access$getInternalClass(WasmSymbols.kt:32)
    at org.jetbrains.kotlin.backend.wasm.WasmSymbols$WasmReflectionSymbols.<init>(WasmSymbols.kt:64)
    at org.jetbrains.kotlin.backend.wasm.WasmSymbols.<init>(WasmSymbols.kt:72)
    at org.jetbrains.kotlin.backend.wasm.WasmBackendContext.<init>(WasmBackendContext.kt:117)
    at org.jetbrains.kotlin.backend.wasm.WasmCompilerKt.compileToLoweredIr(wasmCompiler.kt:70)
    at org.jetbrains.kotlin.cli.js.K2JsIrCompiler.doExecute(K2JsIrCompiler.kt:361)
    at org.jetbrains.kotlin.cli.js.K2JSCompiler.doExecute(K2JSCompiler.java:181)
    at org.jetbrains.kotlin.cli.js.K2JSCompiler.doExecute(K2JSCompiler.java:72)
    at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:104)
    at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:48)
    at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:101)
    at org.jetbrains.kotlin.daemon.CompileServiceImpl.compile(CompileServiceImpl.kt:1523)
    at sun.reflect.GeneratedMethodAccessor26.invoke(Unknown Source)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)
    at sun.rmi.server.UnicastServerRef.dispatch(UnicastServerRef.java:357)
    at sun.rmi.transport.Transport$1.run(Transport.java:200)
    at sun.rmi.transport.Transport$1.run(Transport.java:197)
    at java.security.AccessController.doPrivileged(Native Method)
    at sun.rmi.transport.Transport.serviceCall(Transport.java:196)
    at sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:573)
    at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:834)
    at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:688)
    at java.security.AccessController.doPrivileged(Native Method)
    at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:687)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:750)


> Task :compileTestDevelopmentExecutableKotlinWasmWasi FAILED
e: java.lang.NullPointerException: null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor
    at org.jetbrains.kotlin.backend.wasm.WasmSymbols.findClass(WasmSymbols.kt:387)
    at org.jetbrains.kotlin.backend.wasm.WasmSymbols.getClass$backend_wasm(WasmSymbols.kt:396)
    at org.jetbrains.kotlin.backend.wasm.WasmSymbols.getIrClass(WasmSymbols.kt:416)
    at org.jetbrains.kotlin.backend.wasm.WasmSymbols.getInternalClass(WasmSymbols.kt:417)
    at org.jetbrains.kotlin.backend.wasm.WasmSymbols.access$getInternalClass(WasmSymbols.kt:32)
    at org.jetbrains.kotlin.backend.wasm.WasmSymbols$WasmReflectionSymbols.<init>(WasmSymbols.kt:64)
    at org.jetbrains.kotlin.backend.wasm.WasmSymbols.<init>(WasmSymbols.kt:72)
    at org.jetbrains.kotlin.backend.wasm.WasmBackendContext.<init>(WasmBackendContext.kt:117)
    at org.jetbrains.kotlin.backend.wasm.WasmCompilerKt.compileToLoweredIr(wasmCompiler.kt:70)
    at org.jetbrains.kotlin.cli.js.K2JsIrCompiler.doExecute(K2JsIrCompiler.kt:361)
    at org.jetbrains.kotlin.cli.js.K2JSCompiler.doExecute(K2JSCompiler.java:181)
    at org.jetbrains.kotlin.cli.js.K2JSCompiler.doExecute(K2JSCompiler.java:72)
    at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:104)
    at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:48)
    at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:101)
    at org.jetbrains.kotlin.daemon.CompileServiceImpl.compile(CompileServiceImpl.kt:1523)
    at sun.reflect.GeneratedMethodAccessor26.invoke(Unknown Source)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)
    at sun.rmi.server.UnicastServerRef.dispatch(UnicastServerRef.java:357)
    at sun.rmi.transport.Transport$1.run(Transport.java:200)
    at sun.rmi.transport.Transport$1.run(Transport.java:197)
    at java.security.AccessController.doPrivileged(Native Method)
    at sun.rmi.transport.Transport.serviceCall(Transport.java:196)
    at sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:573)
    at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:834)
    at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:688)
    at java.security.AccessController.doPrivileged(Native Method)
    at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:687)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:750)
```