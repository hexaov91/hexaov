//timer oo
//string s,ss,s2
//int a111N,c
//list a111
a111.clear();
FileUtil.listDir("/storage/emulated/0/Download/154_HuaMuLan/skill", a111);
//skill資料夾目錄

a111N = a111.size() - 1; 
oo = new TimerTask() {
	@Override
	public void run() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				s = FileUtil.readFile(a111.get((int)(a111N)));
				int c =s.indexOf("\"resourceName\" value=\"");
								
				if (!(c == -1)) {										
					ss=s.substring(c); 					
					int cc =ss.indexOf(" refParamName" );					
					s2=s.substring(c+22,cc+c); 
				}
				else {
					s2 = "";
				}
				
				FileUtil.writeFile(a111.get((int)(a111N)), FileUtil.readFile(a111.get((int)(a111N))).replace("\"resourceName2\" value=\"\"", "\"resourceName2\" value=\"".concat(s2)));
				FileUtil.writeFile(a111.get((int)(a111N)), FileUtil.readFile(a111.get((int)(a111N))).replace("\"resourceName3\" value=\"\"", "\"resourceName3\" value=\"".concat(s2)));
				a111N = a111N - 1;
				if (a111N == 0) {
					oo.cancel();
				}
			}
		});
	}
};
_timer.scheduleAtFixedRate(oo, (int)(100), (int)(10));