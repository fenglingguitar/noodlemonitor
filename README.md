# noodlemonitor

noodlemonitor是一款轻量级的服务性能监控工具 <br><br>

DEMO: <br>

git clone https://github.com/fenglingguitar/noodlecommon.git <br>
mvn install -Dmaven.test.skip=true <br><br>

安装/启动本地redis <br><br>

git clone https://github.com/fenglingguitar/noodlemonitor.git <br>
mvn package -P=dev -Dmaven.test.skip=true <br><br>

部署/运行 控制台 noodlemonitor-console-web/target/noodlemonitor.war <br><br>

访问http://localhost:8080/noodlemonitor <br><br>

运行 org.fl.noodlemonitor.client.demo.ClientDemo <br><br>

点击各页刷新按钮，待树形结构显示后，选择查看监控指标 <br><br>
