wget -q -O /tmp/iltools.zip https://www.nuget.org/api/v2/package/runtime.linux-x64.Microsoft.NETCore.ILAsm/10.0.8
jar -x -f /tmp/iltools.zip -C /tmp/iltools
cp /tmp/iltools/runtimes/linux-x64/native/ilasm ~/.dotnet/tools/dotnet-ilasm
chmod +x ~/.dotnet/tools/dotnet-ilasm
rm -r /tmp/iltools*
wget -q -O /tmp/iltools.zip https://www.nuget.org/api/v2/package/runtime.linux-x64.Microsoft.NETCore.ILDAsm/10.0.8
jar -x -f /tmp/iltools.zip -C /tmp/iltools
cp /tmp/iltools/runtimes/linux-x64/native/ildasm ~/.dotnet/tools/dotnet-ildasm
chmod +x ~/.dotnet/tools/dotnet-ildasm
rm -r /tmp/iltools*

