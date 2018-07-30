
===========================================================================================
ChannelScan实验
===========================================================================================
本实验的目的：
1、在ZX2530A 型CC2530 节点板上运行自己的程序。
2、了解信道扫描的概念。

===========================================================================================
实验步骤：
1. 准备2个CC2530射频板，参考实验指导书1.2章节，将无线节点板跳线设置为模式一，分别接上出厂电源； 
2. 将工程文件main.c中的节点类型变量NODE_TYPE的值设置为0，信道变量RF_CHANNEL设置为13，选择Project->Rebuild All重新编译工程；（注意：在实验室中多个小组同时实验时，为防止相互间的信道干扰，RF_CHANNEL应设置为不同值，可按小组编号设置，这里举例设为13）
3. 将仿真器连接到第1个CC2530节点板，上电CC2530节点板，然后点击菜单Project->Download and debug下载程序到此节点板。此节点以下称为接收节点。
4. 将工程文件main.c中节点类型变量NODE_TYPE第值设置为1，选择Project->Rebuild All重新编译工程；
5. 将仿真器连接到第2个CC2530节点板，上电CC2530节点板，然后点击菜单Project->Download and debug下载程序到此节点板。此节点以下称为发送节点。
6. 将接收节点，上电并复位。 
7. 将发送节点通过串口线连接到 PC上，打开串口调试助手，配置串口助手波特率为19200。 
8. 上电并复位发送节点，可是看到串口上打印出信道监听结果及接收到的数据。



以下是程序正确运行之后终端上显示的结果：
scan channel 11 ... Not Use
scan channel 12 ... Not Use
scan channel 13 ... In Use
scan channel 14 ... Not Use
scan channel 15 ... Not Use
scan channel 16 ... Not Use
scan channel 17 ... Not Use
scan channel 18 ... Not Use
scan channel 19 ... Not Use
scan channel 20 ... Not Use
scan channel 21 ... Not Use
scan channel 22 ... Not Use
_

