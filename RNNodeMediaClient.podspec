require 'json'

Pod::Spec.new do |s|
  package = JSON.parse(File.read(File.join(__dir__, 'package.json')))

  s.name          = "RNNodeMediaClient"
  s.version       = package['version']
  s.summary       = package['description']
  s.authors       = { "Mingliang Chen" => "" }
  s.homepage      = "https://github.com/NodeMedia/react-native-nodemediaclient#readme"
  s.license       = "MIT"
  s.platforms     = { :ios => "8.0", :tvos => "9.0" }
  s.framework     = 'UIKit'
  s.requires_arc  = true
  s.source        = { :git => "https://github.com/NodeMedia/react-native-nodemediaclient.git", :tag => "master" }
  s.source_files  = "ios/**/*.{h,m}"

  s.dependency 'React'
  s.dependency 'NodeMediaClient'
end