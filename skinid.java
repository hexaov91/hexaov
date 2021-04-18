//timer oo
//string s,ss,s2
//int a111N,c
//list a111
a111.clear();
FileUtil.listDir("/storage/emulated/0/Download/130_GongBenWuZang/skill/", a111);
//skill資料夾的目錄
a111N = a111.size() - 1;
oo = new TimerTask() {
	@Override
	public void run() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				s = FileUtil.readFile(a111.get((int)(a111N)));
				int c =s.indexOf(
				"\"skinId\" value=\"");
				
				if (!(c == -1)) {
					ss=s.substring(c); 
					
					int cc =ss.indexOf(" refParamName" );
					
					s2=s.substring(c+16,cc+c-1); 
					FileUtil.writeFile(a111.get((int)(a111N)), FileUtil.readFile(a111.get((int)(a111N))).replace("\"skinId\" value=\"".concat(s2.substring((int)(0), (int)(3)).concat("00")), "\"skinId\" value=\"".concat(s2.substring((int)(0), (int)(3)).concat("99"))));
					FileUtil.writeFile(a111.get((int)(a111N)), FileUtil.readFile(a111.get((int)(a111N))).replace("\"skinId\" value=\"".concat(s2), "\"skinId\" value=\"".concat(s2.substring((int)(0), (int)(3)).concat("00"))));
				}
				else {
					s = "";
				}
				a111N = a111N - 1;
				if (a111N == 0) {
										oo.cancel();
				}
			}
		});
	}
};
_timer.scheduleAtFixedRate(oo, (int)(100), (int)(10));