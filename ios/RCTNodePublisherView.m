//
//  RCTNodePublisherView.m
//
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017-2024年 NodeMedia. All rights reserved.
//

#import "RCTNodePublisherView.h"
#import "RCTNodeMediaClient.h"
#import <NodeMediaClient/NodeMediaClient.h>

@interface RCTNodePublisherView () <NodePublisherDelegate>

@property(strong, nonatomic) NodePublisher *np;

@property (nonatomic) BOOL isPreview;
@end

@implementation RCTNodePublisherView

- (id)init {
  self = [super init];
  if (self) {
      _np = [[NodePublisher alloc] initWithLicense:[RCTNodeMediaClient license]];
      [_np setNodePublisherDelegate:self];
      [_np attachView:self];
  }
  return self;
}

- (void)dealloc
{
    [_np detachView];
    [_np closeCamera];
    [_np stop];
}

-(void) onEventCallback:(nonnull id)sender event:(int)event msg:(nonnull NSString*)msg {
    if (_onChange) {
        _onChange(@{@"code": [NSNumber numberWithInteger:event], @"msg": msg});;
    }
}

- (void)setHWAccelEnable:(BOOL)HWAccelEnable {
    [_np setHWAccelEnable:HWAccelEnable];
}

- (void)setDenoiseEnable:(BOOL)denoiseEnable {
    [_np setDenoiseEnable:denoiseEnable];
}

- (void)setCryptoKey:(NSString *)cryptoKey {
    [_np setCryptoKey:cryptoKey];
}

- (void)setEnhancedRtmp:(BOOL)enhancedRtmp {
    [_np setEnhancedRtmp:enhancedRtmp];
}

- (void)setTorchEnable:(BOOL)torchEnable {
    [_np enableTorch:torchEnable];
}

- (void)setRoomRatio:(float)roomRatio {
    [_np setRoomRatio:roomRatio];
}

- (void)setFrontCamera:(BOOL)frontCamera {
    if(_frontCamera != frontCamera) {
        _frontCamera = frontCamera;
        if(_isPreview) {
            [self stopPreview];
            [self startPreview];
        }
    }
}

- (void)setCameraDevice:(int)cameraDevice {
    if(_cameraDevice != cameraDevice) {
        _cameraDevice = cameraDevice;
        if(_isPreview) {
            [self stopPreview];
            [self startPreview];
        }
    }
}

- (void)setVideoOrientation:(int)videoOrientation {
    [_np setVideoOrientation:videoOrientation];
}

- (void)setKeyFrameInterval:(int)keyFrameInterval {
    [_np setKeyFrameInterval:keyFrameInterval];
}

- (void)setVolume:(float)volume {
    [_np setVolume:volume];
}

- (void)setAudioParam:(NSDictionary *)audioParam {
    int codecid = [[audioParam objectForKey:@"codecid"] intValue];
    int profile = [[audioParam objectForKey:@"profile"] intValue];
    int samplerate = [[audioParam objectForKey:@"samplerate"] intValue];
    int channels = [[audioParam objectForKey:@"channels"] intValue];
    int bitrate = [[audioParam objectForKey:@"bitrate"] intValue];
    [_np setAudioParamWithCodec:codecid profile:profile samplerate:samplerate channels:channels bitrate:bitrate];
}

- (void)setVideoParam:(NSDictionary *)videoParam {
    int codecid = [[videoParam objectForKey:@"codecid"] intValue];
    int profile = [[videoParam objectForKey:@"profile"] intValue];
    int width = [[videoParam objectForKey:@"width"] intValue];
    int height = [[videoParam objectForKey:@"height"] intValue];
    int fps = [[videoParam objectForKey:@"fps"] intValue];
    int bitrate = [[videoParam objectForKey:@"bitrate"] intValue];
    [_np setVideoParamWithCodec:codecid profile:profile width:width height:height fps:fps bitrate:bitrate];
}

-(int)start{
    if(!_url) {
        return -1;
    }
    return [_np start:_url];
}

-(int)stop {
    return [_np stop];
}

-(int)startPreview {
    _isPreview = true;
    NSLog(@"suze %f %f",self.bounds.size.width,self.bounds.size.height);
    return [_np openCameraDevice:_cameraDevice withFront:_frontCamera];;
}

-(int)stopPreview {
    _isPreview = false;
    return [_np closeCamera];
}

@end
